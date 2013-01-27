import random

cannedlist = ['Who is best pony?', "How do you think we could make this 20 percent cooler?", "Wouldn't you agree that Friendship is Magic?", "Aren't the Cutie Mark Crusaders cute?", "What's your cutie mark? Sadly, I'm a blank flank.", "Would you like some cider from Sweet Apple Acres?", "I'm gonna love and tolerate till the end of time.", "I'd like to be a tree." ]
num_canned = len(cannedlist)
rounds = int(raw_input('How many rounds? \n>'))
conversation = []
mirror = {'you': 'I', 'I':'you', 'am':'are', 'are':'am'}
start = 'Hey there, everypony! How are you today?'
end = 'Goodbye Everypony!'


def say(x):
    print x
    conversation.append(x)

say(start)

for _ in range(rounds):
    user = raw_input('\n>')
    conversation.append(user)
    userwords = user.split()
    computer = ''
    mirror_words_found = False
    for word in userwords:
        if word in mirror:
            word = mirror[word]
            mirror_words_found = True
            computer = computer + ' ' + word
        else:
            computer = computer + ' ' + word
    if mirror_words_found:
        say(computer)
    else:
        say(random.choice(cannedlist))

say(end)

print '\n\n'
print "Transcript"
for i in conversation:
    print i

