# Excel to json

## excel format

| key | language-1  | language-2   |   |   |
|-----|-------------|--------------|---|---|
| id  | language-id | language2-id |   |   |
|     |             |              |   |   |
|     |             |              |   |   |

## example

| key | en  | tr   | 
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