cd football-ui
rm -r dist
cd ../src/main/resources/static
rm -r *.*
cd ../../../../football-ui
npm install
npm run-script build --watch
cd ../
mvn clean install
java -jar target/football-0.0.1-SNAPSHOT.jar