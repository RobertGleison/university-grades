def encrypt(string_value: str, key: int) -> str:
    answer = ''
    for letter in string_value:
        if not str.isalpha(letter): answer+=letter
        elif str.islower(letter): answer += chr((ord(letter) + key - 97) % 26 + 97)
        else: answer += chr((ord(letter) + key - 65) % 26 + 65)
    return answer

def decrypt(string_value: str, key: int) -> str:
    answer = ''
    for letter in string_value:
        if not str.isalpha(letter): answer+=letter
        elif str.islower(letter): answer += chr((ord(letter) - key - 97) % 26 + 97)
        else: answer += chr((ord(letter) - key - 65) % 26 + 65)
    return answer

def brute_force(string_text: str, keyword: str = None) -> None:
    answers = []
    for key in range(1,len(string_text)+1):
        answer = ''
        for letter in string_text:
            if not str.isalpha(letter):
                answer += letter
            if str.islower(letter) and ord(letter) < 123 and ord(letter) > 96:
                answer += chr((ord(letter) + key - 97) % 26 + 97)
            if str.isupper(letter) and ord(letter) < 91 and ord(letter) > 64:
                answer += chr((ord(letter) + key - 65) % 26 + 65)
        answers.append(answer)
    
    if not keyword:
        for answer in answers:        
            print(answer)
        return    

    if keyword in answer:
        print(answer) 
            

test_brute_force = 'baeeq klwosjl osk s esf ozg cfwo lgg emuz.'
brute_force(test_brute_force, "knew")
