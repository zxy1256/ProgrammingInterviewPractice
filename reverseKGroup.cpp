class Solution {
public:
ListNode* reverseKGroup(ListNode* head, int k) {
ListNode *current,*next,*prev;
ListNode *temp = new ListNode(-1),*dum = head;
temp->next = head;
prev = temp;
int count=0;
while(dum!=NULL)
{
dum = dum->next; //calculating the length of linked list.
count++;
}
for(int i=0; i<count/k; i++)
{
current = prev->next;
next = current->next;
for(int i = 0; i<k-1; i++)
{
current->next = next->next; //the four fololowing steps are to reverse the order of k set of numbers.
next->next = prev->next;
prev->next = next;
next = current->next;
}
prev = current;
}
return temp->next;
}
};