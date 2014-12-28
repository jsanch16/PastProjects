class Triangle
  attr_accessor :a,:b,:c
  def initialize(s1,s2,s3)
    @a,@b,@c = s1,s2,s3
  end

  def perimeter
    if self.test == 'not triangle'
      "Can't calculate perimeter, not a triangle"
    else
      a + b + c
    end
  end

  def area
    if self.test == 'not triangle'
      "Can't calculate area, not a triangle"
    else
      s = (self.perimeter)/2.0
      area = Math.sqrt(s*(s-a)*(s-b)*(s-c))
    end
  end

  def test
    if !((a+b > c) && (a+c > b) && (b+c > a))
      'not triangle'
    else
      case
        when a==b && b==c
          'equilateral'
        when a==b || b==c || a==c
          'isosceles'
        when a != b && b!=c
          'scalene'
        when (a**2 + b**2) == c**2
          'right'
        else
          'not triangle'
      end
    end
  end
end

print 'Enter side a: '
a = gets.chomp.to_i
print 'Enter side b: '
b = gets.chomp.to_i
print 'Enter side c: '
c = gets.chomp.to_i

tri = Triangle.new(a,b,c)
puts "Triangle with sides: a=#{tri.a} b=#{tri.b} c=#{tri.c}"
puts "Triangle type: #{tri.test}"
puts "Perimeter: #{tri.perimeter}"
puts "Area: #{tri.area}"