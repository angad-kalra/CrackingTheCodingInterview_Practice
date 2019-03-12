count = 0

def quickSort(low, high):
	global count
	count+=1
	if(low<high):
		pivot = partition(low, high)
		quickSort(low, pivot - 1)
		quickSort(pivot + 1, high)


def partition(low, high):
	pivot = nums[high]
	i = low - 1
	for j in range(low,high):
		if(nums[j]<=pivot):
			i+=1
			nums[i], nums[j] = nums[j], nums[i]

		j+=1
	nums[i+1], nums[high] = nums[high], nums[i+1]

	return i+1


nums = [10,9,8,7,6,5,4,3,2,1]
quickSort(0, len(nums) - 1)
print(nums)
print("no of calls = " + str(count))