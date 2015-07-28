package first

class figtoword {
	static def tens = [ "" ,"ten","twenty", "thirty","forty","fifty","sixty", "seventy","eighty","ninety" ]
	static def units = ["","one", "two", "three","four","five","six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
		"fourteen", "fifteen","sixteen", "seventeen", "eighteen","nineteen"]
	
	static def convert (  number) {
		if (number == 0 ) 
			return "zero"
		if (number < 0)
			return "minus" + convert(-number)
		if(number < 20)
			return units[number]
	    if (number < 100) 
			return tens[number.intdiv(10)] + " " + units [number % 10]
		if(number < 1000) {
			if( number % 100 == 0)
				return units[number.intdiv(100)] + " hundred"
			else
				return units[number.intdiv(100)] + " hundred and " + convert (number % 100)
		}
			
		
		if(number < 100000 )
			return convert(number.intdiv(1000)) + " thousand " + convert ( number % 1000)
			
		if(number < 10000000 )
			return convert(number.intdiv(100000)) + " lakhs " + convert ( number % 100000)
			
		if(number < 1000000000 )
			return convert(number.intdiv(10000000)) + " crores " + convert ( number % 10000000)
			
	}
	
	
	static void main (def args) {
		
	
		println  figtoword.convert(67500) 
		
		assert figtoword.convert(2) == 'two'
		assert figtoword.convert(10) == 'ten'
		assert figtoword.convert(13) == 'thirteen'
		assert figtoword.convert(53) == 'fifty three'		
		assert figtoword.convert(100) == 'one hundred'
		assert figtoword.convert(345) == 'three hundred and forty five'
		assert figtoword.convert(3500) == 'three thousand five hundred'
		assert figtoword.convert(1045) == 'one thousand forty five'
		
	}
	
}

