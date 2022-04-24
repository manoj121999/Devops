#!/bin/bash
sudo docker build -t surya .
sudo docker run -d -p 8083:8080 surya
echo " Your App is started ON $PORT"
