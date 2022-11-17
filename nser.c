#include"linklist.h"
void reverse(list l)
{
	list p,r;
	p=(list)malloc(sizeof(struct node));
	r=(list)malloc(sizeof(struct node));
	p=l->next;
	l->next=NULL;
	while(p!=0)                    //用头插法将链表进行倒置；
	{         
		r=p->next;
		p->next=l->next;
		l->next=p;
		p=r;
	}
}

void init(list l)
{
	l=(list)malloc(sizeof(struct node));
	l=NULL;
}

int main()
{
	list head,p;                      //创建两个结点；
	head=(list)malloc(sizeof(struct node));
	p=(list)malloc(sizeof(struct node));
    p=creat();                //对无头结点链表进行输入；
	
	head->next=p;           //head为头结点，并head的存放p的地址；
	printf("当前链表:");
	print(head);
	printf("倒置后:");
	reverse(head);
	print(head);
	while(1);
	return 0;
}

