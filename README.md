# Ushahidi Java SDK #

A Java wrapper for the Ushahidi API. It's simply a Java library that wraps the raw HTTP calls to the Ushahidi APIs. 
The goal of this SDK is to ease Ushahidi API integration into your applications and to support all the Ushahidi public and admin APIs that are there. 
For more information on the Ushahidi API, see; https://wiki.ushahidi.com/display/WIKI/Ushahidi+REST+API

## Building
The Ushahidi Java SDK is built using [Apache Ant]()

Run the following command to build a JAR file of the SDK with all the dependencies.
`ant dist` 

And to compile all the source codes, run
`ant compile`

## Example

### Create UshahidiApi object
The UshahidiApi class allows you to access the various task implemented by this SDK 
through the object you will create.

```java
UshahidiApi ushahidi = new UshahidiApi("http://demo.ushahidi.com");

//set credentials for the admin APIs
ushahidi.factory.client = new UshahidiHttpClient();
ushahidi.factory.client.setAuthentication(new PasswordAuthentication(
				"username", "password"));

```

### Fetch all categories
Pull all visible categories that have been submitted to the Ushahidi platform

```java
CategoriesTask task = ushahidi.factory.createCategoriesTask();
List<Category> categories = task.all();
```

### Attach news article
Add a news article to an existing report

```java
TagNewsTask task = ushahidi.factory.createTagNewsTask();
Response response = task.tagNews(4, "http://www.android.com/whatsnew/");
```

### Add comment
Add a comment to an existing report. You need to know the report ID to be able 
to add the comment

```java
Comment c = new Comment();
c.setAuthor("Foo Bar");
c.setReportId(64);
c.setDescription("Some sample comments");

CommentFields comment = new CommentFields();
comment.fill(c);
comment.setEmail("foo@bar.com");
CommentsTask task = ushahidi.factory.createCommentsTask();
Response response = task.submit(comment);
```

### Submit Report
Submit a new report to the Ushahidi deployment

```java
ReportTask task = ushahidi.factory.createReportTask();
Incident i = new Incident();
i.setTitle("test title");
i.setDescription("test desc");
i.setDate(new Date());
i.setLatitude(12.34);
i.setLongitude(56.78);
i.setLocationName("foobar");

ReportFields fields = new ReportFields();
fields.fill(i);
fields.addCategory(7);
fields.addPhotos(new File("/sdcard/photo0.jpg"));
Response response = task.submit(fields);
```

## Javadoc 
You can find the Javadoc which contains all the relevant documentation on the classes 
and the packages in the doc directory found in the root folder of the project.

To generate recent version of the Javadoc, run 
`ant javadoc`

## Clean up
To clean up the generated distribution file and Javadoc in the root folder, run 
`ant clean`
