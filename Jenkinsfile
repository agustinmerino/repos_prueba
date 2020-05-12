node{
    stage('CMS'){
        echo 'Gathering code from version control...'
        git branch:${branch} , url: 'https://github.com/FeynmanFan/JenkinsGroovy.git'
    }
    stage('Build'){
        echo 'Building ...'
        sh 'dotnet --version'
        sh 'dotnet build ConsoleApp1'
    }
    stage('Test'){
        echo 'Testing ...'
    }
    stage('Deploy'){
        echo 'Deploying ...'
    }
}
