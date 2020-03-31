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