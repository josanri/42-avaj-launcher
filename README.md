# avaj-launcher - Project
## Compilation
```
$find * -name "*.java" > sources.txt
$javac @sources.txt
```
## Execution
```
$java com.school42.malaga.avaj.Simulator <scenario_file>
```
### Scenario file example
```
25
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```
# Design patterns used
- Singleton
- Factory
- Observer
