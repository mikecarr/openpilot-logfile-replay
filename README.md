openpilot-logfile-replay
========================


* https://code.google.com/p/dex2jar/ - converts dex to regular java jars

> Check the releases tab for tarball's that have been built already.

### Setup

copy src/main/resources/jars folder to where you are running the run command

### Compile

```
mvn -U clean compile assembly:single
```

### Run

```
sh run.sh -l <full path to log file>
```

or

```
java -jar target/openpilot-logfile-replay-1.0-SNAPSHOT-jar-with-dependencies.jar <location of you log file>

i.e.
java -jar target/openpilot-logfile-replay-1.0-SNAPSHOT-jar-with-dependencies.jar /Users/mcarr/Desktop/OP-RC3/OP-2014-07-17_17-52-20.opl
```

### Report
Application will create a file in the data folder with uavo object data in csv format numbered by the order of when the event is processed.

### Sample File
There is a sample file in the sample-file directory

#### Sample Output from OP GCS

```
2014-07-21 10:36:58,188 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Received object : 6440104E>
2014-07-21 10:36:58,188 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Received object: CameraDesired>
2014-07-21 10:36:58,188 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Unpacking existing object: CameraDesired>
2014-07-21 10:36:58,188 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Known ID: D7E0D964>
2014-07-21 10:36:58,188 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Received object : D7E0D964>
2014-07-21 10:36:58,188 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Received object: AttitudeState>
2014-07-21 10:36:58,188 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Unpacking existing object: AttitudeState>
2014-07-21 10:36:58,189 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Known ID: 4AFDB658>
2014-07-21 10:36:58,189 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Received object : 4AFDB658>
2014-07-21 10:36:58,189 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Received object: PositionState>
2014-07-21 10:36:58,189 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Unpacking existing object: PositionState>
2014-07-21 10:36:58,189 DEBUG[org.openpilot_nonag.uavtalk.UAVTalk] - <Known ID: EAE65C28>
```

#### References

http://wiki.openpilot.org/display/Doc/Android+Telemetry
