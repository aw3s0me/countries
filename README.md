# Kotlin Test
## Functionality
* App shows info about countries (as table)
* User can download data as CSV
* Data is stored in H2 Database
* Additional script (init.sh) is used to upload countries.txt data to DB

## Practices
* SOLID
* KISS
* TDD
* MVC
* Hibernate

# Installation
## Backend
Go to main directory and run 
```
./gradlew bootRun
```

## Frontend
### Gradle based installation
This uses gradle to run angular 4 app

To use external NodeJS go to build.gradle
in ./frontend folder
and change node.download property to true

Go to main directory and run
```
./gradlew npmStart
```

### Npm based installation
This uses npm and ng utils to run angular 4 app

1. Install node js (tested on 6.11.1) and npm (tested on 3.10.10)
2. Go to frontend folder
3. Install angular-cli and tsc (typescript) (latest) globally to enable ng util
4. run `npm install` to install dependencies
5. Run `npm start run` to run angular 4 app
6. Go to localhost:4200
