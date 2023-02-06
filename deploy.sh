#!/bin/bash
TASK=`sudo aws ecs list-tasks --cluster DEMO --service Demo_app --desired-status RUNNING --region ap-south-1--output text | awk '{print $2}'`
sudo aws ecs stop-task --cluster DEMO --task $TASK
echo "Task stopped successfully"
