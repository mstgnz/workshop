list1 = [[1, 'a', ['cat'], 2], [[[3]], 'dog'], 4, 5]
list2 = [[1, 2], [3, 4], [5, 6, 7]]


def def1(list1):
    for l in list1:
        if type(l) == list:
            def1(l)
        else:
            print(l, end=" ")


def def2(list2):
    newList = list()
    for l in list2:
        if type(l) == list:
            l.reverse()
            newList.append(l)
        else:
            l.reverse()
            newList.append(l)
    print(newList)


def1(list1)
print()
def2(list2)
