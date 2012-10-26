/*
 * http://www.leetcode.com/2010/10/implement-strstr-to-find-substring-in.html
 * The loop structure here is similar to the one in merge 2 sorted list
 */
char* StrStr(const char *str, const char *target) {
    if (target == NULL) {
        return str;
    }
    
    if (str == NULL) {
        return NULL;
    }
    char* strPtrAdv = str;
    char* targetPtr = target;
    while (*targetPtr) {
        strPtrAdv++;
        targetPtr++;
    }
    char* current = str;
    while (*strPtrAdv='\0') {
        char* targetCurrent = target;
        char* result = current;
        while (*current != '\0' 
            && *targetCurrent != '\0' 
            && *targetCurrent == *current) {
                targetCurrent++;
                current++;
        }
        if (targetCurrent == '\0') {
            return result;
        }
        current++
        strPtrAdv++;     
    }
    return NULL;
}
