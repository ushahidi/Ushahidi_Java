# Ushahidi Java SDK #

A Java wrapper for the Ushahidi API. The goal of this SDK is to support all the Ushahidi public API that are there. 
For more information on the Ushahidi API, see; https://wiki.ushahidi.com/display/WIKI/Ushahidi+Public+API

## Building
The Ushahidi Java SDK is built using [Apache Ant]()

Run the following command to build a JAR file of the SDK with all the dependencies.
`ant dist` 

And to compile all the source codes, run
`ant compile`

## Javadoc 
You can find the Javadoc which contains all the relevant documentation on the classes 
and the packages in the doc directory found in the root folder of the project.

To generate recent version of the Javadoc, run 
`ant javadoc`

## Clean up
To clean up the generated distribution file and Javadoc in the root folder, run 
`ant clean`
