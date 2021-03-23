package com.n26;

import com.n26.TestConfig;
import com.n26.TestRunnerBase;
import lombok.SneakyThrows;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Converts the cucumber JSON reports to html reports.
 * The visual features of the reports is configurable
 */
public class TestReportGenerator {

    public static Properties metadata = new Properties();

    @SneakyThrows
    public static void generate(TestConfig props) {
        String dirOldPath = System.getProperty("user.dir") + "/target/cucumber-reports";
        String newDirPath = System.getProperty("user.dir") + "/" + TestRunnerBase.getReportPath();
        File oldDir = new File(dirOldPath.replace("\\", "/"));
        File newDir = new File(newDirPath.replace("\\", "/"));

        FilenameFilter jsonFilter = (dir, fileName) -> fileName.endsWith(".json");

        if (oldDir.exists()) {
            if (newDir.exists()) {
                File[] repFiles = oldDir.listFiles(jsonFilter);
                for (File repfile : repFiles) {
                    repfile.renameTo(new File(newDir.getAbsolutePath() + "/" + repfile.getName()));
                }
            } else {
                oldDir.renameTo(newDir);
            }
        }


        File[] files = newDir.listFiles(jsonFilter);
        // iterate through all the JSON reports
        List<String> jsonFiles = new ArrayList<>();
        for (File jsonfile : files) {
            BufferedReader brTest = new BufferedReader(new FileReader(jsonfile));
            //exclude empty files
            if (!brTest.readLine().equals("[]")) {
                jsonFiles.add(jsonfile.getAbsolutePath());
            } else {
                jsonfile.deleteOnExit();
            }
            brTest.close();
        }

        String buildNumber = "1";
        String projectName = "N26";
        File reportOutputDirectory = new File(TestRunnerBase.getReportPath());

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setRunWithJenkins(false);
        configuration.setBuildNumber(buildNumber);

        File f = new File(newDirPath + "/reportmetadata.properties");
        OutputStream out = new FileOutputStream(f);
        metadata.store(out, "This is an optional header comment string");
        List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add(newDirPath + "/reportmetadata.properties");
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }


}
