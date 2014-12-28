#!/usr/bin/ruby -w

puts 'if-then:'
x,y = 15,15
if x == y then
  puts "x is equal to y"
end

puts 'if-else:'
a,b = 1,2
if a == b then
  puts "a is equal to b"
else
  puts "a is not equal to b"
end

puts 'if-elsif-else:'
grade = 92
if grade >= 90
  puts "A"
elsif grade >=80 && grade < 90
  puts "B"
elsif grade >=70 && grade < 80
  puts "C"
elsif grade >=60 && grade < 70
  puts "D"
else
  puts "F"
end

puts 'unless:'
unless grade >= 60
  puts "Fail"
else
  puts "Pass"
end

x,y = 4,5
puts 'if Modifier:'
puts "#{x} < #{y}" if x<y

puts 'unless Modifier'
puts "#{x} <  #{y}" unless (x > y)



puts 'case statement:'
m = 9
month = case
          when m == 1
            puts "January"
          when m == 2
            puts "February"
          when m == 3
            puts "March"
          when m == 4
            puts "April"
          when m == 5
            puts "May"
          when m == 6
            puts "June"
          when m == 7
            puts "July"
          when m == 8
            puts "March"
          when m == 9
            puts "March"
          when m == 10
            puts "October"
          when m == 11
            puts "November"
          when m == 12
            puts "December"
        end

puts 'case-selector:'
age = 14
case age
  when 0 .. 2
    puts "Baby"
  when 3 .. 12
    puts "Kid"
  when 13 .. 19
    puts "Teenager"
  else
    puts "Adult"
end