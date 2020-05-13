node{
    stage('CMS'){
        echo 'Gathering code from version control...'
        git branch:'${branch}' , url: 'https://github.com/FeynmanFan/JenkinsGroovy.git'
    }
    stage('Build'){
        echo 'Building ...'
        releasenotes()
    }
    stage('Test'){
        echo 'Testing ...'
    }
    stage('Deploy'){
        echo 'Deploying ...'
    }
}
