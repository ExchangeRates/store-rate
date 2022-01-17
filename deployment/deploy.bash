cd ..

mvn clean install

docker build -t sr -f deployment/dockerfile .
docker tag sr azch97/sr:latest
docker push azch97/sr:latest


scp -r ./deployment/kubernetes server:~/store-rate
ssh server 'kubectl replace --force -f ~/store-rate/service.yml'
ssh server 'kubectl replace --force -f ~/store-rate/deployment.yml'

