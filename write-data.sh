#!/bin/bash
while true
do
	temperature=$(cat /sys/bus/w1/devices/28-0316453fdaff/w1_slave | grep  -E -o ".{0,0}t=.{0,5}" | cut -c 3-)
	echo $(date +%s) $temperature >> data.txt
	sleep 600
done
