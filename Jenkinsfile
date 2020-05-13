node{
    stage('CMS'){
        echo 'Gathering code from version control...'
        git branch:'${branch}' , url: 'https://github.com/FeynmanFan/JenkinsGroovy.git'
    }
    stage('Build'){
        try{
            echo 'Building ...'
            releasenotes(changes:"true")
        }catch(ex){
            echo 'something when wrong'
            echo ex.toString()
            current.Build.result = 'FAILURE'
        }

        
    }
    stage('Test'){
        echo 'Testing ...'
    }
    stage('Deploy'){
        echo 'Deploying ...'
    }
}
