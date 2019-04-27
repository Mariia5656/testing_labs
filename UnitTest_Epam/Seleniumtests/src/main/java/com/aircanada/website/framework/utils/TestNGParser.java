package com.aircanada.website.framework.utils;

import org.testng.collections.Lists;
import org.testng.collections.Maps;
import org.testng.xml.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestNGParser extends Parser {

    private static final ISuiteParser DEFAULT_FILE_PARSER = new SuiteXmlParser();
    private static final List<ISuiteParser> PARSERS = Lists.newArrayList(DEFAULT_FILE_PARSER);
    private final String fileName;
    private final InputStream inputStream;
    private final IPostProcessor postProcessor;

    public TestNGParser(String fileName) {
        super(fileName);
        this.fileName = fileName;
        inputStream = null;
        postProcessor = null;
    }

    private static IFileParser getParser(String fileName) {
        for (ISuiteParser parser : PARSERS) {
            if (parser.accept(fileName)) {
                return parser;
            }
        }
        return DEFAULT_FILE_PARSER;
    }

    @Override
    public Collection<XmlSuite> parse() throws IOException {
        List<String> processedSuites = Lists.newArrayList();
        XmlSuite resultSuite = null;

        List<String> toBeParsed = Lists.newArrayList();
        List<String> toBeAdded = Lists.newArrayList();
        List<String> toBeRemoved = Lists.newArrayList();

        if (fileName != null) {
            File mainFile = new File(fileName);
            toBeParsed.add(mainFile.getCanonicalPath());
        }

        Map<String, XmlSuite> childToParentMap = Maps.newHashMap();
        while (toBeParsed.size() > 0) {

            for (String currentFile : toBeParsed) {
                File currFile = new File(currentFile);
                File parentFile = currFile.getParentFile();
                InputStream inputStream = this.inputStream != null ? this.inputStream : new FileInputStream(currentFile);

                IFileParser<XmlSuite> fileParser = getParser(currentFile);
                boolean m_loadClasses = true;
                XmlSuite currentXmlSuite = fileParser.parse(currentFile, inputStream, m_loadClasses);
                processedSuites.add(currentFile);
                toBeRemoved.add(currentFile);

                if (childToParentMap.containsKey(currentFile)) {
                    XmlSuite parentSuite = childToParentMap.get(currentFile);
                    currentXmlSuite.setParentSuite(parentSuite);
                    parentSuite.getChildSuites().add(currentXmlSuite);
                }

                if (null == resultSuite) {
                    resultSuite = currentXmlSuite;
                }

                List<String> suiteFiles = currentXmlSuite.getSuiteFiles();
                if (suiteFiles.size() > 0) {
                    for (String path : suiteFiles) {
                        String pathFull = Common.checkFileExtension(path, "xml");
                        String canonicalPath;
                        if (parentFile != null && new File(parentFile, pathFull).exists()) {
                            canonicalPath = new File(parentFile, pathFull).getCanonicalPath();
                        } else {
                            canonicalPath = new File(pathFull).getCanonicalPath();
                        }
                        if (!processedSuites.contains(canonicalPath)) {
                            toBeAdded.add(canonicalPath);
                            childToParentMap.put(canonicalPath, currentXmlSuite);
                        }
                    }
                    currentXmlSuite.setSuiteFiles(new LinkedList<>());
                }
            }

            for (String s : toBeRemoved) {
                toBeParsed.remove(s);
            }
            toBeRemoved = Lists.newArrayList();

            toBeParsed.addAll(toBeAdded);
            toBeAdded = Lists.newArrayList();

        }

        List<XmlSuite> resultList = Lists.newArrayList();
        resultList.add(resultSuite);

        if (postProcessor != null) {
            return postProcessor.process(resultList);
        } else {
            return resultList;
        }
    }

    @Override
    public List<XmlSuite> parseToList() throws RuntimeException {
        try {
            List<XmlSuite> result = Lists.newArrayList();
            Collection<XmlSuite> suites = parse();
            result.addAll(suites);
            return result;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
