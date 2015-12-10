def newCounter = 0
def reCounter = { File fileName ->
    def matcher = (fileName.name =~ /^(\d+)([a-z]?)\.(pag)$/)[0]
    def (_, String counter, String part, String extension) = matcher
    if (!part || (part == 'a'))
        newCounter++
    def newCounterPad = "${newCounter}".padLeft(counter.size(), '0')
    "${fileName.parent}/${newCounterPad}${part}.${extension}" as File
}

def files = ('c:/test') as File
File[] filesSorted = files.listFiles().sort()
for (file in filesSorted) {
    def fileRename = reCounter(file)
    println "Renaming '${file.name}' to '${fileRename.name}'"
    file.renameTo(fileRename)
}

