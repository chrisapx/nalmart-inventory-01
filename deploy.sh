##!/bin/bash
#
#
## SSH into VPS
#ssh -i root@89.107.61.102
#
## Start SSH agent
#eval "$(ssh-agent -s)"
#
## Add private key
#ssh-add ~/.ssh/git-key
#
## Move to the directory
#cd /root/backend/nalmart-server-01
#
## Pull the latest repo changes
#git pull
#
## Stop Spring Boot application running on port 8080
#kill $(lsof -t -i:8080)
#
## Start Spring Boot application in the background
#nohup mvn spring-boot:run > springboot.log 2>&1 &
