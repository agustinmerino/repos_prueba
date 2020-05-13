import java.io.*;
import groovy.io.*;
import java.text.*
import hudson.model.*;

@NonCPS
def call(Map config=[:]){
    def dir = new File(pwd());
    println pwd()
    new File(dir.path+'/releasenotes.txt').withWriter('utf-8'){
        writer ->
            dir.eachFileRecurse(FileType.ANY){
                file -> 
                    if(file.isDirectory()){
                         writer.writeLine(file.name);
                    }else{
                         writer.writeLine('\t'+file.name + '\t' + file.length());
                    }
               
            }
    }
    def date = new Date()
    def sdf  = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    println "Date and Time Is: ${sdf.format(date)}"
    println "Build Number is: ${BUILD_NUMBER}"

    def changeLogSets = currentBuild.changeSets;
    for(change in changeLogSets){
        def entries = change.items;
        for(entry in entries){
            echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg} "
            for(file in entry.affectedFiles){
                echo "  ${file.editType.name} ${file.path}"
            }

        }
    }
    if(config.changes != "false"){
        println "changes"
    }
}
