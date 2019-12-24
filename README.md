# kafka_producer_consumer
kafka producer consumer basic json message send example


download java jdk,zookeeper, kafka from official site
create environment variable
JAVA_HOME C:\Program Files (x86)\jdk-13\
ZOOKEEPER_HOME C:\Users\suyashsingh\Downloads\zookeeper
edit path as %JAVA_HOME%\bin %ZOOKEEPER_HOME%\bin
go to zookeeper 
edit conf/zoo.cfg, dataDir=C:/Users/suyashsingh01/Downloads/zookeeper/data
open cmd
run zkServer
open cmd
run zkCli for running zookeeper command
go to kafka folder 
change server.properties log file folder
go to kafka/bin/windows
make sure path for kafka is small otherwise you ll get error
run
kafka-server.start.bat C:\kafka\config\server.properties 
open cmd go to kafka bin windows

create a topic name NDS-Topic
bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic NDS-Topic
list of topic
bin\windows\kafka-topics.bat --list --zookeeper localhost:2181 test
alter a topic
bin\windows\kafka-topics.bat --zookeeper localhost:2181 --alter --topic NDS-Topic1 --config retention.ms=1000

start producer to send the message
bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic NDS-Topic

start consumer to recieve the message
bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic NDS-Topic --from-beginning

open producer , consumer maven project using any eclipse ide,intellij
run producer
http://localhost:8081/produce/send/test/test/test3 
output sent successfully!
run consumer
you ll see output at console
