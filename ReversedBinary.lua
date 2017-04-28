open = io.open

-- READ FILE
function read_file(path)
	file = open(path, "rb") -- r read mode and b binary mode
	if not file then return nil end
	content = file:read "*a" -- *a or *all reads the whole file
	file:close()
	return content
end

filecontent = read_file("File.txt")

-- PROCESS
function chars(str)
	strc = {}
	for i = 1, #str do
		table.insert(strc, string.sub(str, i, i))
	end
	return strc
end

function reverse(t)
	local nt = {} -- new table
	local size = #t + 1
	for k,v in ipairs(t) do
		nt[size - k] = v
	end
	return nt
end

function tobits(num)
	local t={}
	while num>0 do
		rest=num%2
		t[#t+1]=rest
		num=(num-rest)/2
	end
	t = reverse(t)
	return table.concat(t)
end

str = string.reverse(filecontent)
dec = chars(str)

--WRITE
files = open("Result.bin", "wb")

for i = 1, #str do
	res = tobits(string.byte(dec[i]))
	files:write(res .. " ")
end

files:close()