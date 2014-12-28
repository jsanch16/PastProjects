

def mean_sigma(arr)
  mean = 0.0
  stdev = 0.0

  #calculate mean
  arr.each do |x|
    mean += x
  end
  mean = mean/arr.length


  #calulate (xi-mu)^2 values
  arr.each do |x|
    stdev += (x - mean) ** 2
  end

  #calculate mean of (xi-mu)^2 values
  stdev/=(arr.length-1)
  stdev = Math.sqrt(stdev)

  return mean,stdev
end


a = [1,2,3,4,5,6,7,8]
print "array= ",a,"\n"
puts "[mean,standard dev]= #{mean_sigma a}"