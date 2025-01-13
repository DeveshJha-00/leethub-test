typedef struct {
    int data[100];
    int front;
    int rear;
    int size;
} Queue;

Queue* createQueue() {
    Queue *q = (Queue *)malloc(sizeof(Queue)); 
    q->front = 0;
    q->rear = -1;
    q->size = 0;
    return q;
}

typedef struct {
    Queue *q1;
    Queue *q2;
} MyStack;


MyStack* myStackCreate() {
    MyStack *obj = (MyStack *)malloc(sizeof(MyStack));
    obj->q1 = createQueue();
    obj->q2 = createQueue();
    return obj;
}

void enqueue(Queue *q, int x) {
    if ( q->size == 100) {
        return;
    }
    q->rear = (q->rear + 1) % 100;  
    q->data[q->rear] = x;
    q->size++;
}

int dequeue(Queue *q) {
    if (q->size == 0) {
        return -1; 
    }
    int item = q->data[q->front];
    q->front = (q->front + 1) % 100;  
    q->size--;
    return item;
}

void myStackPush(MyStack* obj, int x) {
    enqueue(obj->q1, x);
}

int myStackPop(MyStack* obj) {
     // Move all elements from Q1 to Q2, except the last element
    while (obj->q1->size > 1) {
        int ele = dequeue(obj->q1);
        enqueue(obj->q2, ele);
    }
     // The last element in Q1 is the one to pop
    int item = dequeue(obj->q1);

    // Move all elements back from Q2 to Q1
    while (obj->q2->size != 0) {
        int ele = dequeue(obj->q2);
        enqueue(obj->q1, ele);
    }

    return item;
}

int myStackTop(MyStack* obj) {
    // Move all elements from Q1 to Q2, except the last element
    while (obj->q1->size > 1) {
        int ele = dequeue(obj->q1);
        enqueue(obj->q2, ele);
    }
    // The last element in Q1 is the top element
    int item = dequeue(obj->q1);
    enqueue(obj->q2, item); //Only need to return ele, not remove from queue

    // Move all elements back from Q2 to Q1
    while (obj->q2->size != 0) {
        int ele = dequeue(obj->q2);
        enqueue(obj->q1, ele);
    }

    return item;
}

bool myStackEmpty(MyStack* obj) {
    return (obj->q1->size == 0);
}

void myStackFree(MyStack* obj) {
    free(obj->q1);
    free(obj->q2);
    free(obj);
}

/**
 * Your MyStack struct will be instantiated and called as such:
 * MyStack* obj = myStackCreate();
 * myStackPush(obj, x);
 
 * int param_2 = myStackPop(obj);
 
 * int param_3 = myStackTop(obj);
 
 * bool param_4 = myStackEmpty(obj);
 
 * myStackFree(obj);
*/