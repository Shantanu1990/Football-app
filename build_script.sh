cd football-ui
rm -r dist
cd ../src/main/resources/static
rm -r *.*
cd ../../../../football-ui
if [! -d "node_modules" ]
then
	echo "Starting npm install"
	npm install
fi
echo "npm installed running npm run"
npm run-script build --watch
cd ../
echo "running mvn clean install"
mvn clean install
java -jar target/football-0.0.1-SNAPSHOT.jar