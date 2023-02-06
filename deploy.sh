#!/bin/bash
TASK=`aws ecs list-tasks --cluster DEMO --service Demo_app --desired-status RUNNING --output text | awk '{print $2}'`
aws ecs stop-task --cluster DEMO --task $TASK
echo "Task stopped successfully"
