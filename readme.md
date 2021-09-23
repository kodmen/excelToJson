# Excel to json

## excel format

| Key | language-1  | language-2   |   |   |
|-----|-------------|--------------|---|---|
| id  | language-id | language2-id |   |   |
|     |             |              |   |   |
|     |             |              |   |   |

## example

| Key | en  | tr   | 
|-----|-------------|--------------|
| title  | hello | merhaba | 
| country    |   Turkey         |     türkiye         |  
|  paragraph   |   The modern web application platform for Java          |    Java için modern web uygulama platformu          |  

## result

en.json
```json
{
"title":"hello",
"country":"Turkey",
  "paragraph": "The modern web application platform for Java"
}
```


tr.json
```json
{
"title":"merhaba",
"country":"türkiye",
  "paragraph": " Java için modern web uygulama platformu"
}
```

## to get the jar of the project
1. git clone project
2. proje build
3. mvn clean package  
4. maven jar:jar
5. target/ExcelTojson-1.0-jar-with-dependencies.jar will be created

## to run the project
. java -jar ${jar-file}.jar ${excel-file}.xlxs

