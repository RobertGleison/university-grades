public class Teste<T> {
        private Node<T> first;    // Primeiro no da lista
        private int size;         // Tamanho da lista

        Teste() {
            this.first = null;
            this.size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public void addFirst(T value) {
            Node<T> novo = new Node<T>(value, this.first);
            this.first = novo;
            size++;
        }

        public void addLast(T value) {
            Node<T> novo = new Node<T>(value, null);
            if (isEmpty())
                this.first = novo;
            else {
                Node<T> current = first;
                while (current.getNext() != null) // enquanto o current não for o último
                    current = current.getNext();
                current.setNext(novo);
            }
            size++;
        }

        public T getFirst() {
            if (isEmpty()) return null;
            else
                return first.getValue();
        }

        public T getLast() {
            if (isEmpty()) return null;
            else {
                Node<T> current = first;
                while (current.getNext() != null) // enquanto o current não for o último
                    current = current.getNext();
                return current.getValue();
            }
        }

        public void removeFirst() {
            if (!isEmpty()) {
                this.first = first.getNext();
                size--;
            }
        }

        public void removeLast() {
            if (isEmpty()) return;
            if (size == 1) this.first = null;
            else {
                Node<T> cur = first;
                for (int i=0; i<size-2; i++)
                    cur = cur.getNext();
                cur.setNext(cur.getNext().getNext());
            }
            size--;
        }

        public String toString() {
            String str = "{";
            Node<T> current = first;
            for (int i=0; i<size; i++) {
                str += current.getValue();
                current = current.getNext();
                if (i!=size-1) str += ",";
            }
            str += "}";
            return str;
        }

        public T get(int pos) {
            Node<T> current = first;
            if (pos>=size || pos<=0)
                return null;
            for (int i=0; i<pos; i++)
                current = current.getNext();
            return current.getValue();
        }
    }

