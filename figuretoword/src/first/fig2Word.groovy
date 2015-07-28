class figtoword {
	static def units = ["0": "", "1":"one", "2":"two", "3": "three", "4":"four","5":"five","6":"six","7":"seven","8":"eight","9":"nine"]
	static def tens1 = ["00": "", "10": "ten", "11": "eleven", "12": "twelve", "13": "thirteen", "14": "fourteen", "15": "fifteen", "16": "sixteen", "17": "seventeen", "18": "eighteen", "19": "nineteen"]
	static def tens2 = ["0": "", "1": tens1, "2": "twenty", "3": "thirty", "4": "forty", "5": "fifty", "6": "sixexty", "7": "seventy", "8": "eighty", "9": "ninety" ]
	static def digitPlaceMap = ["0": "", "1": units, "2": tens2, "3": units, "4": units, "5": tens2, "6": units, "7": tens2]
	static def specialPlaceStr = ["0": "", "3": "hundred and", "4": "thousand", "6": "lakh", "8": "crore"]
	
	static def convertFigToWord (number) {
	def doubleDigit = ""
	def numIndex = number.size()
	number.each { it ->
			if (doubleDigit.size() == 0) {
				if (it == "1" && ((numIndex == 2) || (numIndex == 5) || (numIndex == 7))) {
					doubleDigit += it
				}
				else {
					String nStr = numIndex
					print digitPlaceMap[nStr][it] + " "
					if (digitPlaceMap[nStr][it] != "" && specialPlaceStr[nStr] != null) {
						print specialPlaceStr[nStr] + " "	
					}
				}
			}
			else {
				doubleDigit += it
				String nStr = (numIndex + 1)
				print digitPlaceMap[nStr]["1"][doubleDigit] + " " 
				doubleDigit = ""
			}
			numIndex--
		}
	}
	
	static void main (def args) {	

		convertFigToWord.convert("67500"); 
		
		
		assert convertFigToWord.convert(2) == 'two'
		assert convertFigToWord.convert(10) == 'ten'
		assert convertFigToWord.convert(13) == 'thirteen'
		assert convertFigToWord.convert(53) == 'fifty three'		
		assert convertFigToWord.convert(100) == 'one hundred'
		assert convertFigToWord.convert(345) == 'three hundred and forty five'
		assert convertFigToWord.convert(3500) == 'three thousand five hundred'
		assert convertFigToWord.convert(1045) == 'one thousand forty five'
		
	}
}
