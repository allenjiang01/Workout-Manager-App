# Workout Manager

## Proposal


The goal of this project is to create an application which allows users to create and customize weekly workout 
programs. In the beginning, all users will be able to enter their **fitness level** where 
the system will then process and generate a corresponding program to fit their needs. More advanced users may choose
to make their own program by creating from scratch or adding and deleting exercises of their choice. 
Workouts will be categorized by days, up to a full week. While the pre-made 
exercises will differ for different skill levels,
the three levels: **beginner, intermediate, and advanced** will all contain a mixture of upper body, lower body,
and cardio. 

The primary audience for this application are those wanting a systematic way of monitoring their workout exercises.
As a gym enthusiast myself, I find it inconvenient to keep track of my workout plans on general document 
applications. I think many gym goers will find this application very handy and practical.   

### User Stories

- As a user, I want to be able to generate a pre-made workout program suited to my fitness level.
- As a user, I want to be able to add new exercises for a specific day to my program.
- As a user, I want to be able to remove existing exercises for a specific day from my program.
- As a user, I want to be able to view the list of all exercises for a specific day in my program.

- As a user, I want to be able to save my workout program to file
- As a user, I want to be able to be able to load my workout program from file 
 
 
### Phase 4: Task 2

Made use of HashMap to save exercises as a set.
- **Usage classes:** Workout, ConsoleInterface, GraphicalInterface.

### Phase 4: Task 3

Possible design improvements:
- Preset Interface could be removed if I saved its fields as fields in WeeklyWorkout. 
- UI classes could be refactored to smaller focused classes.
- Methods in UI classes could be refactored to different shorter methods.

