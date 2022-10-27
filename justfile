# gRPC compile with Reactor code generation
grpc-compile:
   mvn protobuf:compile

# build project
build: grpc-compile
   mvn -DskipTests clean package

# generate gRPC docs
grpc-docs:
   mkdir -p target
   protoc --doc_out=./target --doc_opt=html,index.html src/main/proto/*.proto
   open target/index.html


# list services
services:
   grpcurl -plaintext localhost:50052 list

# grpcurl test
curl:
   grpcurl -plaintext -d '{"id": 1234}' localhost:50052 org.mvnsearch.service.AccountService/findAccount

# gui web
gui-web:
   grpcui -plaintext localhost:50052 &

# setup
setup:
   go install github.com/pseudomuto/protoc-gen-doc/cmd/protoc-gen-doc@v1.5.1
   go install github.com/fullstorydev/grpcui/cmd/grpcui@latest
   go install github.com/fullstorydev/grpcurl/cmd/grpcurl@latest


   