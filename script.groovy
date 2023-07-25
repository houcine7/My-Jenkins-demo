def checkChanges(){
    // Get the current change sets
    def changeSets = currentBuild.changeSets
    // Check if there are any changes
    if (changeSets != null && !changeSets.isEmpty()) {
        echo "Changes detected. Running the build stage..."
    } else {
        echo "No changes. Skipping the build stage."
        currentBuild.result = 'SUCCESS' // Mark the build as successful
        return
    }
}

def build(){
     echo 'BUILDING TEH APP'
     echo "YOUR APPLICATION VERSION IS ${params.VERSION}"
}

return this