#!/bin/sh

CMD="java -jar target/openpilot-logfile-replay-1.0-SNAPSHOT-jar-with-dependencies.jar"

usage()
{
    echo "usage: <command> options:<l,u>"
    echo "l = full path to flight log"
    echo "u = uavo jar"
    echo "h = this help screen" 
    echo ""
    echo "list of uavos:"
    ls -1 jars
   
}

while getopts ":l:u:" opt; do
  case $opt in
    l) LOG_FILE_PATH="$OPTARG"
    ;;
    u) arg_1="$OPTARG"
    ;;
   *)
      usage
      exit;;
  esac
done

$CMD $LOG_FILE_PATH $arg_1
