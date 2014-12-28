
class Array

  def limited?(amin,amax)
    self.each do |x|
      if !(amin<= x && x <= amax)
         return false
      end
    end
    return true
  end

  def sorted?
    ascending =true
    descending = true

    self.each_cons(2) do |x,y|
      if !(x <=y) then ascending = false end
      if !(x >=y) then descending = false end
    end

    case
      when ascending && !descending then 1
      when descending && !ascending then -1
      else 0
    end
  end

end

myArray = [1,5,8,2,6]
print myArray,"\n"
print 'Enter min: '
min = gets.chomp.to_i
print 'Enter max: '
max = gets.chomp.to_i
puts "is the array in range?(#{min}-#{max}): #{myArray.limited?(min,max)}"
puts "is the array ascending(1), descending(-1), or not sorted(0)?: #{myArray.sorted?}"