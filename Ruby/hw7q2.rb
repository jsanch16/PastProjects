#!/usr/bin/ruby -w

puts 'loop-do:'
n=0
loop do
  if n > 5 then
    break
  end
  puts "#{n}"
  n+=1
  end

puts 'while-do:'
n=0
while n <= 5 do n

  puts "#{n}"
  n+=1

end

puts 'until-do:'
n=0
until n > 5 do
  puts "#{n}"
  n+=1
end

puts 'while modifier:'
n=0
begin
  puts "#{n}"
  n+=1
end while n <= 5


puts 'until modifier:'
n=0
begin
  puts "#{n}"
  n+=1
end until n > 5

puts 'for-in-do:'
for j in 0 .. 5 do
  puts "#{j}"
end

puts 'upto:'
0.upto(5) do |n|
puts "#{n}"
end

puts 'downto:'
5.downto(0) do |n|
puts "#{n}"
end

puts 'times(implicit)'
n=0
6.times do
  puts n
  n+=1
end

puts 'times(explicit)'
6.times do |x|
  puts x
end

puts 'each:'
(0..5).each do |i|
  puts "#{i}"
end

a= [1,2,3]
puts 'each_with_index:'
a.each_with_index do |item,index|
  puts index
end

puts 'map:'
b= a.map do |x|
  x*2 
end
puts b

puts 'step:'
0.step(25,5) do |i|
  puts i
end
