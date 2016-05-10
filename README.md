#Features

##MessageSourceHolder
####This component can be used to call statically an instance of **MessageSource**
Example
![](http://s32.postimg.org/b3pk3fjlx/Screen_Shot_2016_05_08_at_12_55_56_PM.png)

This can be used on classes non managed by spring.

##HTTPContextHolder
####This component can be used to get statically the server address

```java
  HTTPContextHolder.getServerURL()
```
This return a server full URL containing the scheme + the server host + port (if is not the 80) and the context name (when have).
This can be used on classes non managed by spring.

##DWR Converters (HibernateBeanConverter & LocalDateTimeConverter)

##Custom Hibernate PostgreSQL Dialect
Supporting a custom HQL function called `FILTER()`

##Easy file management via Java JCR
Infrastructure to store files via JCR implemented by Modeshape supported by a generic file repository `IMetaFileRepository` and its entity `MetaFile`.

##Support of TRUNCATE TABLE to the DBUnit
```java
CascadeTruncateTableOperation.java
```
##ReportManager
####Report generator implemented by `JasperReportManager`
Supported methods:
```java
	public ByteArrayOutputStream exportToPDF( Map<String, Object> parameters, String reportPath );
	public ByteArrayOutputStream exportToHTML( Map<String, Object> parameters, String reportPath );
	public ByteArrayOutputStream exportToXML( Map<String, Object> parameters, String reportPath );
	public ByteArrayOutputStream exportToXLS( Map<String, Object> parameters, String reportPath );
```

##MimeType
####Enum constants for 450 mimetypes.


#Final Build
mvn deploy -DperformRelease=true -Dmaven.javadoc.skip=true
