sudo apt update
sudo apt upgrade -y
sudo apt install docker.io -y





sudo docker tag config_company:latest company:latest
sudo docker tag config_startup:latest startup:latest
sudo docker tag ir_ir:latest ir:latest
sudo docker tag board_board:latest board:latest
sudo docker tag config_user:latest user:latest
sudo docker tag config_shop:latest shop:latest
sudo docker tag config_communication:latest communication:latest




docker build --tag company:latest ./microservices/company
docker build --tag startup:latest ./microservices/startup-composite
docker build --tag ir:latest ./microservices/ir
docker build --tag board:latest ./microservices/board
docker build --tag user:latest ./microservices/user
docker build --tag shop:latest ./microservices/shop
docker build --tag communication:latest ./microservices/communication

docker build --tag eureka-server:latest ./cloud/eureka-server
docker build --tag config-server:latest ./cloud/config_server



docker tag company ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/company:latest

docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/company:latest


docker build --tag startup:latest ./microservices/startup-composite
docker tag startup ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/startup
docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/startup

docker build --tag ir:latest ./microservices/ir
docker tag ir ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/ir
docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/ir

docker build --tag board:latest ./microservices/board
docker tag board ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/board
docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/board

docker build --tag user:latest ./microservices/user
docker tag user ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/user
docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/user

docker build --tag shop:latest ./microservices/shop
docker tag shop ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/shop
docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/shop

docker build --tag communication:latest ./microservices/communication
docker tag communication ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/communication
docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/communication



docker build --tag company:latest ./microservices/company
docker tag company ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/company
docker push ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/company








sudo docker pull ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/company
sudo docker pull ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/startup
sudo docker pull ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/ir
sudo docker pull ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/board
sudo docker pull ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/user
sudo docker pull ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/shop
sudo docker pull ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/communication



OPTIONS='--selinux-enabled --log-driver=journald --signature-verification=false --insecure-registry=ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000
if [ -z "${DOCKER_CERT_PATH}" ]; then
    DOCKER_CERT_PATH=/etc/docker
fi

sudo vi /etc/docker/daemon.json

{
    "insecure-registries": ["ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000"]
}

{
    "insecure-registries": ["13.209.17.102:5000"]
}

sudo service docker restart
sudo docker login "ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000"
sudo docker login "13.209.17.102:5000"


docker network create --attachable --driver overlay fabric-samples


base=https://github.com/docker/machine/releases/download/v0.16.2 &&
curl -L $base/docker-machine-$(uname -s)-$(uname -m) >/tmp/docker-machine &&
sudo install /tmp/docker-machine /usr/local/bin/docker-machine



docker-machine create --driver amazonec2 --amazonec2-instance-type t2.medium --amazonec2-region ap-northeast-2 api-test-master

docker-machine create --driver amazonec2 --amazonec2-instance-type t2.medium --amazonec2-region ap-northeast-2 --swarm --swarm-master api-test-master


sudo docker service create --name startup -p 8080:8080 -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/startup:latest

sudo docker service create --name user -p 7301:7301 -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/user

sudo docker network create -d overlay api-test
--network ingress
--network api-test
sudo docker service create --name startup -p 8080:8080 -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=2 --with-registry-auth 13.209.17.102:5000/startup:latest
sudo docker service create --name user -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/user
sudo docker service create --name company -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/company
sudo docker service create --name ir -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/ir
sudo docker service create --name board -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/board
sudo docker service create --name shop -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/shop
sudo docker service create --name communication -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 --with-registry-auth 13.209.17.102:5000/communication

sudo docker service create --name startup -p 8080:8080 -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/startup
sudo docker service create --name user -e SPRING_PROFILES_ACTIVE="swam-test" --replicas=1 ec2-13-209-17-102.ap-northeast-2.compute.amazonaws.com:5000/user


sudo docker service create --name hostname -p 8080:80 --replicas=1 --network fabric-samples alicek106/book:hostname