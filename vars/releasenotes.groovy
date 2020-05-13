import java.io.*;
import groovy.io.*;

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
    def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    println "Date and Time Is: ${sdf.format(date)}"
    
    if(config.changes != "false"){
        println "changes"
    }
}
