# CSE360 Final Group Project

This tool gives teachers the ability to track and view how much of their class is attending their online lectures and for how long.
The teacher can manage multiple rosters of students by loading them into the display, adding their attendence data for that day, 
view the data, and then save the roster with the attendence and repeat with another class roster.

## Functionality

This tool has 5 main functionalities.

### Load a Roster

Loads a Roster from the CSV file that the user selected.
Can load new rosters without headers and attendance. 
And can also load previously saved rosters with headers and attendance.

### Add Attendance

Adds the attendance data (in minutes attended) to the roster from an attendance CSV that the user selected.
Students in the roster who arent in the attendance data are assumed to have not attended class and are given an attendance of 0 minutes.
If a student leaves the class and comes back later their attendance data is combined.
Students that arent in the roster are ignored and reported to the user.

### Save a Roster

Saves the current roster with attendance data to a CSV on the user's file system so that it can be used at another time.

### Plot Attendance Data

Plots the attendance data in a scatterplot so the user can view the attendance distribution.
The X-axis is the percentage of class the students attended, and the Y-axis is the number of students who attended for that percentage of class.

## Design

This project implements the Model View Controller Architecture as well as the Observer-Observable design pattern.
User events are sent to the controller which executed functions in the observable model, changing the program state. When the model is finished computing and the state change is complete it notifies its respective Observers in the View which update accordingly.

## Authors

- Hunter Paulson
- Yasser Dbeis
- Aidan Morgan
- Junghwan (Kevin) Park
- Darshan Vamathevan
