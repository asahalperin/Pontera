# Pontera

Pontera assignment

## Running Tests

### UI Test
#### To run UI tests, use this Maven command on project root. Yoy can choose browser at the end (Parameter Dbrowser = chrome / edge / firefox)

mvn clean compile test -DsuiteXmlFile=src\test\resources\RunUi.xml -Duser=PonteraTest -Dbrowser=chrome
### API Test
#### To run API tests, use this Maven command on project root: 

mvn clean compile test -DsuiteXmlFile=src\test\resources\RunApi.xml -Duser=PonteraApi

## Reports
Report created under project root directory/Reports - By date and time

## CleanUp
Delete Client can be individual test so i created new test for this purpose instead to delete it using After annotation. It's possible to delete data using Rest API Delete method

## Failures
I added some failures (In comments under AddClients test class) to see the screenshots and failures logs
