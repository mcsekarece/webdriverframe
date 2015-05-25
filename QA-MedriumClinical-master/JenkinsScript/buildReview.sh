#!/bin/bash
cd target/surefire-reports
ls

file='testng-failed.xml'
#search='10.33.3.87'
#replace='10.33.2.140'

#sed -i "s/$search/$replace/" $file

search2='4444'
replace2='4445'

sed -i "s/$search2/$replace2/" $file