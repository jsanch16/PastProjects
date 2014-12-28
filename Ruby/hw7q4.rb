def sort(v)
  arr = Array.new(v)
  sorted = false
  until sorted
    sorted = true
    (arr.count - 1).times do |i|
      if arr[i] > arr[i + 1]
        arr[i], arr[i + 1] = arr[i + 1], arr[i]
        sorted = false
      end
    end
  end
  arr
end

myArray = [1,5,10,2,8,3,7,9]
newArray = sort myArray
print 'original array:',myArray,"\n"
print 'sorted array:',newArray